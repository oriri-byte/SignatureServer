package com.example.eth.demo.domain.service;

import com.example.eth.demo.domain.model.Address;
import com.example.eth.demo.domain.model.DomainName;
import com.example.eth.demo.domain.model.Signature;

public interface IECDSAProvider {
    /**
     * アドレスとドメイン名からECDSA署名を生成する
     * 
     * @param address    署名対象のアドレス
     * @param domainName 署名対象のドメイン名
     * @param privateKey 秘密鍵
     * @return 生成された署名
     */
    Signature sign(Address address, DomainName domainName, String privateKey);
}
