package jes.ioc.dao.rcpmis2;

import jes.ioc.entity.rcpmis2.rcpmis2RptFeedbackLog;

public interface rcpmis2RptFeedbackLogMapper {
    int insert(rcpmis2RptFeedbackLog record);

    int insertSelective(rcpmis2RptFeedbackLog record);
}