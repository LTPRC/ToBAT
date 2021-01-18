package com.github.ltprc.algorithm;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * ������java��дһ��ת�˽ӿڣ�������Ҫҵ���������ת���˺ţ�
 * ת���˺ţ�ת�˽����ת����ת���˺ŵ��ʽ���
 * �÷���Ҫȷ�����ʽ���ʱת���˻�������͸֧��������׼ȷ��
 */
public class TransferTest {

    /**
     * �������������һ��Զ�̷�������
     */
    private String checkAmoutisEnoughRemoteService = "һ������У���û�����Ƿ��㹻��Զ�̷���";
    /*
    * ��Ŀ������
    *    ����ӿڣ�
    *    ��Σ� ת���˺� ת���˺� ת�˽��
    *    Ҫ��
    *       ���ת��ת���˺ŵ��ʽ���
    *       ����ʱת���˻�������͸֧  fromPerson Ҫ�ж�����Ƿ��㹻
    *       ���׼ȷ     ʹ��BigDeceimal
    *
    *    ���ʣ�
    *       �Ƿ���Ҫ����ֵ������ֻ��һ�δ�����
    *
    *
    *    �ؼ��㣺
    *       �ؼ������ǵô���־
    *       ������ڲ�������ǵüӷֲ�ʽ��
    *       ����ĸ��������Ƿ���һЩ������ƣ������������ع�������
    *       ���Զ�̵��ÿ��ܴ��ڵȴ�״̬�����Խ������ԣ������ܵ�ͬ����
    *       ��������첽����̨�Ӷ�ʱ��������첽���ݲ�ѯ������
    *
    */

    // ��������ֱ��д�ӿڣ��Ͳ�������������ˣ������ҪҲ���Զ���һ���������
    // ��Ϊ���ǽӿڣ����Ȱѷ�������

    /**
     * ת�˽ӿڣ�������java��дһ��ת�˽ӿڣ�������Ҫҵ���������ת���˺ţ�
     * ת���˺ţ�ת�˽����ת����ת���˺ŵ��ʽ���
     * �÷���Ҫȷ�����ʽ���ʱת���˻�������͸֧��������׼ȷ��
     *
     * @author he.ai  2019-04-18 20:16
     *
     * @param sourceAccount ��Ŀ�е�ת���˺ţ�Ҳ���Ǵ�˭�����Ǯ�ó���
     * @param destAccout    ��Ŀ�е�ת���˺ţ�Ҳ����Ǯת��˭
     * @param amout  ����Ϊ�ַ��������뽫�ַ���תΪBigDecimal������BigDeceimalҲ�ǿ��Եģ�������������
     *
     * ����������Ҫ���ؽ���Ļ���һ����ù��õ�Result�࣬��װԶ�̵��õ�code��������Ѿ�����֮���
     */
    void transfer(
            String sourceAccount,
            String destAccout,
            String amout
    ){
        // �����������ǿ��Ի�ȡ��ת���˺�(sourceAccout)�����
        // ��Դ����Ϊ��Զ�̵��÷���ֱ�Ӵ����ݿ��ã���֮Ҫ�ܻ�ȡ����ǰ�˻������

        // 1. ���ȶԲ�������У�飬�Ƿ�Ϸ�
        // ������쳣�Ļ����趨���쳣��ʲôλ�ý��д���
        checkParam(sourceAccount, destAccout, amout);
        // Ҳ���Զ��˻��Ƿ������һ�μ���

        // 2. У��ת���˺ŵ�����Ƿ��㹻����һ���������Ƿ���Ȩ�ޣ�
        // �������û��Ȩ�޻�ȡ�û��������Ϣ���������Ȩ�޵Ĳ��Ž����ж�
        // ����������������û��Ȩ��֪���û�������Ҫ�ж�

        // ����Զ�̵Ĳ�������������Ҫ����������ϵͳ����Э��
        HashMap<String, String> map = new HashMap<>();
        map.put("account",sourceAccount);
        map.put("amount",amout);
        Result result = callRemoteService(checkAmoutisEnoughRemoteService, map);
        // ��result���д���
        // �����ж��û�����Ƿ��㹻���ҾͲ�д�ж��߼���


        // 3. ����ת�˲��������������е���������û��˻���ok�ģ����Ҳ��ok��
        // ����ʲô���տ��ƣ��û��Ƿ��а�ȫ�������������Լ�������ϵͳ

        // ���￴Ҫ���Ƿ�Ҫ��һ��ȫ��������п��ƣ���������ݵ�һ����Ҫ��ܸߣ���ô������ȫ�ֵ��������
        // �����������ݵ�һ����Ҫ�󲻸ߣ���ô���ǿ����Ƚ��г������ٲ�д��ʱ���񣬻��߲����첽֪ͨ�ķ�ʽ

        // �������Լ���
        doTransfer(sourceAccount,destAccout,amout);

        // ����һ��������Ǯ�Ѿ�ת���ˣ���Ҫ���Ƿ�Ҫ֪ͨ������ҵ��ϵͳ

        sendNotifytoOthers();

    }

    private void sendNotifytoOthers() {

    }

    /**
     * ���������и�ȫ�����񣬱�������Ҳ��
      */
    @Transactional(rollbackFor = Exception.class)
    public void doTransfer(String sourceAccount, String destAccout, String amout) {
        // ��ʵ��Ȼ���������ˣ�����Ӧ������Ȩ�޻�ȡ����
        // �������������ȡ�����û�������Ȼ����������ϵͳ��������Ҳ�п���
        // �������ǻ���Ҫ��һ�ݱ�������

        // �û�������һ��Ҫ����ϵͳҪ�󣬿����������ȡ
        BigDecimal sourceLeftMoney = new BigDecimal("1000");
        BigDecimal destLeftMoney = new BigDecimal("200");
        // ����һ�����裬���������Ȩ�ޣ��Ҿ�ֱ�Ӹ����ˣ������У��Ҳ���õ���Զ�̷�����

        // ����һ���ORM��ܣ����԰����ǽ���ת��
        // update userDatabase set rest_money = (sourceLeftMoney - amout) where rest_money = sourceLeftMoney and accout = sourceAccount

        // �ǵô���־��
        updatesourceAccount(sourceAccount,amout);

        // �����ʣ������ת���˻���ʣ����
        // update userDatabase set rest_money = (destLeftMoney + amout) where rest_money = destLeftMoney and accout = destAccout
        updatedestAccout(destAccout,amout);
    }

    private void updatedestAccout(String destAccout, String amout) {

    }

    private void updatesourceAccount(String sourceAccount, String amout) {

    }

    /**
     * ���߷���������ֱ�ӵ���Զ�̷���
     * @param checkAmoutisEnoughRemoteService
     * @param map
     */
    private Result callRemoteService(String checkAmoutisEnoughRemoteService, HashMap<String, String> map) {
        // Զ�̷���Ĵ����߼�
        return null;
    }

    static class Result{

    }

    /**
     * ��ʵ����Ķ���������Է�װΪһ������ģ��Ͳ���ר����ô�����
     * @param sourceAccount
     * @param destAccout
     * @param amout
     */
    private void checkParam(String sourceAccount, String destAccout, String amout) {
        if (StringUtils.isEmpty(sourceAccount)){
            // ���ҵ���쳣����Ŀ��һ�㶼���Լ���Ŀ��ҵ���쳣������Ϊ�˷�����׳�������ʱ�쳣
            // �����쳣�Ĳ�����������Ŀѡ�����ڵ�ǰ���в��񣬻��߶���ȫ���쳣���в���
            // ����Ϊ�˷��㣬�ҾͲ������쳣��
            // ����ǹؼ�ҵ�񣬿��Գ��Է�������
            throw new RuntimeException("ҵ���쳣" + "ת���˺�Ϊ��");
        }
        // ���Ը��ݲ�ͬ�Ĳ������׳���ͬ���쳣
        if (StringUtils.isEmpty(destAccout)){
            throw new RuntimeException("ҵ���쳣��" + "ת���˺�Ϊ��");
        }
        if (StringUtils.isEmpty(amout)){
            throw new RuntimeException("ת�˽��Ϊ��");
        }
    }
}