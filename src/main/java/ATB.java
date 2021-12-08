import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class ATB{
    private String name;
    private double cost;
    private int amount;

    public static boolean isEmpty(ATB atb){
        return atb.getName() == null || !(atb.getCost() >= 0) || atb.getAmount() <= 0;
    }

}
