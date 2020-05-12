package pro.kelu.missyou.sample.hero;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pro.kelu.missyou.sample.ISkill;

//@Component
public class Diana implements ISkill {

    public void q() {
        System.out.println("Diana Q");
    }

    public void w() {
        System.out.println("Diana W");
    }

    public void e() {
        System.out.println("Diana E");
    }

    public void r() {
        System.out.println("Diana R");
    }
}
