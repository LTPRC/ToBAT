package com.github.ltprc.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author 应癫
 */
public class CompanyFactoryBean implements FactoryBean<Company> {
    private String companyInfo; // 公司名称,地址,规模

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public Company getObject() throws Exception {
// 模拟创建复杂对象Company
        Company company = new Company();
        String[] strings = companyInfo.split(",");
        company.setName(strings[0]);
        company.setAddress(strings[1]);
        company.setScale(Integer.parseInt(strings[2]));
        return company;
    }

    public Class<?> getObjectType() {
        return Company.class;
    }

    public boolean isSingleton() {
        return true;
    }
}