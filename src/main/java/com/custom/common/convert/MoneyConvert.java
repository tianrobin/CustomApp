package com.custom.common.convert;

import com.custom.common.Money;

import javax.persistence.AttributeConverter;

/**
 * Created by robin.tian on 16-3-17.
 */
public class MoneyConvert implements AttributeConverter<Money, Long> {
    @Override
    public Long convertToDatabaseColumn(Money money) {
        if (money == null) {
            return 0L;
        }
        return money.getCent();
    }

    @Override
    public Money convertToEntityAttribute(Long cent) {
        Money money =  new Money();
        money.setCent(cent);
        return money;
    }
}
