package cn.raxcl.basic.io.IO传输模型.BIO;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String name;
    private int age;
}
