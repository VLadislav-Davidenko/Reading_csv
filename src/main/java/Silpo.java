import lombok.*;

@Builder
@ToString
@Getter
@Setter
public class Silpo {
    private String name;
    private double cost;
    private int amount;

    public static boolean isEmpty(Silpo slp){
        return slp.getName() == null || !(slp.getCost() >= 0) || slp.getAmount() <= 0;
    }

}
