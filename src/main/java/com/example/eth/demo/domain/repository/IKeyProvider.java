package com.example.eth.demo.domain.repository;

public interface IKeyProvider {
    /**
     * @return 厳重に管理された秘密鍵(Hex文字列など)
     */
    String getPrivateKey();
}
