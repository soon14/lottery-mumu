package com.lottery.core.service;

import com.lottery.core.IdGeneratorDao;
import com.lottery.core.SeqEnum;
import com.lottery.core.dao.LotteryChannelPartnerDao;
import com.lottery.core.domain.agency.LotteryChannelPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fengqinyun on 16/5/24.
 */
@Service
public class LotteryChannelPartnerService {
    @Autowired
    private LotteryChannelPartnerDao lotteryChannelPartnerDao;
    @Autowired
    private IdGeneratorDao idGeneratorDao;
    @Transactional
    public LotteryChannelPartner saveOrUpdate(String agencyno,String agencyuser){

        try{
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("agencyno",agencyno);
            map.put("agencyuser",agencyuser);
            LotteryChannelPartner lotteryChannelPartner=lotteryChannelPartnerDao.findByUnique(map);
            return lotteryChannelPartner;
        }catch (Exception e){

        }

        Long id=idGeneratorDao.get(SeqEnum.lotteryChannelPartner);

        LotteryChannelPartner lotteryChannelPartner=new LotteryChannelPartner();

        lotteryChannelPartner.setAgencyno(agencyno);
        lotteryChannelPartner.setAgencyuser(agencyuser);
        lotteryChannelPartnerDao.insert(lotteryChannelPartner);
        return lotteryChannelPartner;
    }



}

