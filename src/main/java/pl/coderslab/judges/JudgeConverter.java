package pl.coderslab.judges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class JudgeConverter implements Converter<String, Judge> {

    @Autowired
    private JudgeService judgeService;

    @Override
    public Judge convert(String s) {
        return judgeService.find(Long.parseLong(s));
    }
}
