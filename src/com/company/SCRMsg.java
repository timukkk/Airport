package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class SCRMsg {

    private Map<Fields, String> fields;

    String getFieldValue(Fields fieldName) {
        return this.fields.get(fieldName);
    }


}
