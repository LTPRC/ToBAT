package com.github.ltprc.algorithm;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 尝试用java编写一个转账接口，传入主要业务参数包括转出账号，
 * 转入账号，转账金额，完成转出和转入账号的资金处理，
 * 该服务要确保在资金处理时转出账户的余额不会透支，金额计算准确。
 */
public class TransferTest {

    /**
     * 假设这个东西是一个远程服务名称
     */
    private String checkAmoutisEnoughRemoteService = "一个可以校验用户余额是否足够的远程服务";
    /*
    * 题目分析：
    *    定义接口：
    *    入参： 转出账号 转入账号 转账金额
    *    要求：
    *       完成转出转入账号的资金处理
    *       处理时转出账户的余额不会透支  fromPerson 要判断余额是否足够
    *       金额准确     使用BigDeceimal
    *
    *    疑问：
    *       是否需要返回值？还是只是一次处理即可
    *
    *
    *    关键点：
    *       关键操作记得打日志
    *       如果存在并发情况记得加分布式锁
    *       其余的根据需求，是否做一些额外控制，比如限流，回滚，重试
    *       如果远程调用可能存在等待状态，可以进行重试，尽可能的同步，
    *       如果可以异步，后台加定时任务进行异步数据查询并更新
    *
    */

    // 我在这里直接写接口，就不定义类的名称了，如果需要也可以定义一下类的名字
    // 因为不是接口，我先把方法留空

    /**
     * 转账接口，尝试用java编写一个转账接口，传入主要业务参数包括转出账号，
     * 转入账号，转账金额，完成转出和转入账号的资金处理，
     * 该服务要确保在资金处理时转出账户的余额不会透支，金额计算准确。
     *
     * @author he.ai  2019-04-18 20:16
     *
     * @param sourceAccount 题目中的转出账号，也就是从谁哪里把钱拿出来
     * @param destAccout    题目中的转入账号，也就是钱转给谁
     * @param amout  定义为字符串，是想将字符串转为BigDecimal，传入BigDeceimal也是可以的，可以再做商量
     *
     * 假设这里需要返回结果的话，一般会用公用的Result类，封装远程调用的code，结果，已经数据之类的
     */
    void transfer(
            String sourceAccount,
            String destAccout,
            String amout
    ){
        // 假设这里我们可以获取到转出账号(sourceAccout)的余额
        // 来源可以为：远程调用服务，直接从数据库拿，总之要能获取到当前账户的余额

        // 1. 首先对参数进行校验，是否合法
        // 如果有异常的话，需定义异常在什么位置进行处理
        checkParam(sourceAccount, destAccout, amout);
        // 也可以对账户是否存在做一次检验

        // 2. 校验转出账号的余额是否足够，这一步看我们是否有权限，
        // 如果我们没有权限获取用户的余额信息，需调用有权限的部门进行判断
        // 我这里假设的是我们没有权限知道用户的余额，需要判断

        // 调用远程的参数，这个入参需要根据与其他系统进行协商
        HashMap<String, String> map = new HashMap<>();
        map.put("account",sourceAccount);
        map.put("amount",amout);
        Result result = callRemoteService(checkAmoutisEnoughRemoteService, map);
        // 对result进行处理
        // 进行判断用户余额是否足够，我就不写判断逻辑了


        // 3. 进行转账操作，代码能运行到这里，代表用户账户是ok的，余额也是ok的
        // 至于什么风险控制，用户是否有安全隐患，看需求，以及其它的系统

        // 这里看要求是否要有一个全局事务进行控制，如果对数据的一致性要求很高，那么可以做全局的事务控制
        // 如果这里对数据的一致性要求不高，那么我们可以先进行出来，再补写定时任务，或者采用异步通知的方式

        // 甚至可以加锁
        doTransfer(sourceAccount,destAccout,amout);

        // 到这一步，假设钱已经转好了，看要求是否要通知其他的业务系统

        sendNotifytoOthers();

    }

    private void sendNotifytoOthers() {

    }

    /**
     * 假设这里有个全局事务，本地事务也行
      */
    @Transactional(rollbackFor = Exception.class)
    public void doTransfer(String sourceAccount, String destAccout, String amout) {
        // 其实既然让我们做了，我们应该是有权限获取余额的
        // 假设我们这里获取到了用户的余额，当然调用其他的系统，真正做也有可能
        // 但是我们还是要有一份备份数据

        // 用户的余额，这一步要根据系统要求，看看从哪里获取
        BigDecimal sourceLeftMoney = new BigDecimal("1000");
        BigDecimal destLeftMoney = new BigDecimal("200");
        // 再做一个假设，如果我们有权限，我就直接更新了，上面的校验也不用调用远程服务了

        // 这里一般的ORM框架，可以帮我们进行转换
        // update userDatabase set rest_money = (sourceLeftMoney - amout) where rest_money = sourceLeftMoney and accout = sourceAccount

        // 记得打日志。
        updatesourceAccount(sourceAccount,amout);

        // 这里的剩余金额是转入账户的剩余金额
        // update userDatabase set rest_money = (destLeftMoney + amout) where rest_money = destLeftMoney and accout = destAccout
        updatedestAccout(destAccout,amout);
    }

    private void updatedestAccout(String destAccout, String amout) {

    }

    private void updatesourceAccount(String sourceAccount, String amout) {

    }

    /**
     * 工具方法，可以直接调用远程服务
     * @param checkAmoutisEnoughRemoteService
     * @param map
     */
    private Result callRemoteService(String checkAmoutisEnoughRemoteService, HashMap<String, String> map) {
        // 远程服务的处理逻辑
        return null;
    }

    static class Result{

    }

    /**
     * 其实这里的多个参数可以封装为一个对象的，就不用专递这么多参数
     * @param sourceAccount
     * @param destAccout
     * @param amout
     */
    private void checkParam(String sourceAccount, String destAccout, String amout) {
        if (StringUtils.isEmpty(sourceAccount)){
            // 这个业务异常，项目内一般都有自己项目的业务异常，这里为了方便就抛出了运行时异常
            // 至于异常的补货，根据项目选择是在当前进行捕获，或者丢给全局异常进行捕获
            // 这里为了方便，我就不捕获异常了
            // 如果是关键业务，可以尝试发出报警
            throw new RuntimeException("业务异常" + "转出账号为空");
        }
        // 可以根据不同的参数，抛出不同的异常
        if (StringUtils.isEmpty(destAccout)){
            throw new RuntimeException("业务异常：" + "转入账号为空");
        }
        if (StringUtils.isEmpty(amout)){
            throw new RuntimeException("转账金额为空");
        }
    }
}