package pro.kelu.missyou.sample.hero;

import org.springframework.stereotype.Component;
import pro.kelu.missyou.sample.ISkill;

@Component
public class Irelia implements ISkill {

    public void q() {
        System.out.println("Irelia Q");
    }

    public void w() {
        System.out.println("Irelia W");
    }

    public void e() {
        System.out.println("Irelia E");
    }

    public void r() {
        System.out.println("Irelia R");
    }
}
