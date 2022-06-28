package fairyShop;

import fairyShop.models.Helper;
import fairyShop.models.Present;
import fairyShop.models.Shop;

public class ShopImpl implements Shop {
    @Override
    public int craft(Present present, Helper helper) {
        boolean flag = false;
        int count = 0;

        for (var instrument : helper.getInstruments()){
            if (!instrument.isBroken() && helper.canWork()){
                while (!instrument.isBroken()){
                    helper.work();
                    instrument.use();
                    present.getCrafted();
                    if (present.isDone()){
                        flag = true;
                        break;
                    }
                }
                if (instrument.isBroken()){
                    count++;
                }
                if (flag){
                    break;
                }
            }
        }

        return count;
    }
}
