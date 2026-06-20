package com.example.eth.demo.usecase;

import org.springframework.stereotype.Service;
import com.example.eth.demo.domain.model.Address;
import com.example.eth.demo.domain.model.DomainName;
import com.example.eth.demo.domain.model.Signature;
import com.example.eth.demo.domain.repository.IKeyProvider;
import com.example.eth.demo.domain.service.IECDSAProvider;
import com.example.eth.demo.usecase.dto.SignRequestDto;
import com.example.eth.demo.usecase.dto.SignResponseDto;

@Service
public class GenerateSignatureUseCase {

    private final IKeyProvider keyProvider;
    private final IECDSAProvider ecdsaProvider;

    public GenerateSignatureUseCase(IKeyProvider keyProvider, IECDSAProvider ecdsaProvider) {
        this.keyProvider = keyProvider;
        this.ecdsaProvider = ecdsaProvider;
    }

    public SignResponseDto execute(SignRequestDto request) {
        // ドメインモデルの生成（ここでバリデーションが走る。不正な値ならIllegalArgumentExceptionがスローされる）
        Address addressObj = new Address(request.getAddress());
        DomainName domainObj = new DomainName(request.getDomain());

        // 秘密鍵の取得
        String privateKey = keyProvider.getPrivateKey();

        // 署名生成
        Signature signature = ecdsaProvider.sign(addressObj, domainObj, privateKey);

        // DTOに詰め直して返却
        return new SignResponseDto(signature.hexValue());
    }
}
