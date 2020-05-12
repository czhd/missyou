package pro.kelu.missyou.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import pro.kelu.missyou.condition.hero.DianaCondition;
import pro.kelu.missyou.condition.hero.IreliaCondition;
import pro.kelu.missyou.sample.hero.Diana;
import pro.kelu.missyou.sample.hero.Irelia;

@Configuration
public class HeroConfiguration {

    @Bean
    @Conditional(DianaCondition.class)
    public ISkill diana() {
        return new Diana();
    }

    @Bean
    @Conditional(IreliaCondition.class)
    public ISkill irelia() {
        return new Irelia();
    }
}
