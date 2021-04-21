package jes.ioc.dao.dna2;

import jes.ioc.entity.dna2.Dna2MetaDataInfo;

public interface Dna2MetaDataInfoMapper {
    int deleteByPrimaryKey(String primaryKey);

    int insert(Dna2MetaDataInfo record);

    int insertSelective(Dna2MetaDataInfo record);

    Dna2MetaDataInfo selectByPrimaryKey(String primaryKey);

    int updateByPrimaryKeySelective(Dna2MetaDataInfo record);

    int updateByPrimaryKey(Dna2MetaDataInfo record);
}