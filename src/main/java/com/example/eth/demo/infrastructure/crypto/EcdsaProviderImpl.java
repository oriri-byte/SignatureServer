package com.example.eth.demo.infrastructure.crypto;

import org.springframework.stereotype.Component;

import org.web3j.crypto.Hash;
import org.web3j.crypto.Sign;
import org.web3j.utils.Numeric;
import com.example.eth.demo.domain.model.Address;
import com.example.eth.demo.domain.model.DomainName;
import com.example.eth.demo.domain.model.Signature;
import com.example.eth.demo.domain.service.IECDSAProvider;
import java.nio.charset.StandardCharsets;

@Component
public class EcdsaProviderImpl implements IECDSAProvider {

    @Override
    public Signature sign(Address address, DomainName domainName, String privateKey) {
        try {
            // Web3jのCredentialsクラスを使用して秘密鍵からキーペアを生成
            // (0xのプレフィックス有無に関わらず安全にパース可能)
            org.web3j.crypto.Credentials credentials = org.web3j.crypto.Credentials.create(privateKey);

            // 署名対象のデータを結合してハッシュ化
            // (ABIエンコード等が必要な場合はここを変更します。ここではシンプルな文字列結合のハッシュを使用)
            String message = domainName.value() + address.value();

            // 署名対象データをログ出力
            System.out.println("--- Signing Data ---");
            System.out.println("Raw Message: " + message);
            System.out.println("--------------------");

            Sign.SignatureData signatureData = Sign.signPrefixedMessage(message.getBytes(StandardCharsets.UTF_8),
                    credentials.getEcKeyPair());

            // r, s, vを結合してHex文字列にする
            // vから27を引く必要がある場合はここで調整が必要ですが、Web3jのSignatureDataは通常そのまま使えます
            String r = Numeric.toHexStringNoPrefix(signatureData.getR());
            String s = Numeric.toHexStringNoPrefix(signatureData.getS());
            String v = Numeric.toHexStringNoPrefix(signatureData.getV());

            return new Signature("0x" + r + s + v);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate ECDSA signature with Web3j", e);
        }
    }
}
