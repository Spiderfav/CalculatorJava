package calcmodel;

import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import view.OpType;

class test {
  public Consumer<OpType> currentType = null;  

  @Test
  void test1() {
    currentType.accept(OpType.STANDARD);
    
    System.out.println(currentType.toString());
  }

}
