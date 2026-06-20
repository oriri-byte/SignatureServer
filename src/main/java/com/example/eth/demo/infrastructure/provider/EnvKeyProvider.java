package com.example.eth.demo.infrastructure.provider;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import com.example.eth.demo.domain.repository.IKeyProvider;

@Component
@org.springframework.context.annotation.PropertySource(value = "file:local.properties", ignoreResourceNotFound = true)
public class EnvKeyProvider implements IKeyProvider {

    // local.properties または application.properties から取得する
    // ecdsa.private.keyプロパティが設定されていない場合はダミーのキーを使用する例
    @Value("${ecdsa.private.key:0x0000000000000000000000000000000000000000000000000000000000000001}")
    private String privateKey;

    @Override
    public String getPrivateKey() {
        return privateKey;
    }
}
