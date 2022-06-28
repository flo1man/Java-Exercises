package fairyShop.core;

import fairyShop.InstrumentImpl;
import fairyShop.PresentImpl;
import fairyShop.ShopImpl;
import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.helper.Happy;
import fairyShop.helper.Sleepy;
import fairyShop.models.Helper;
import fairyShop.models.Instrument;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private int countOfCraftedPresents = 0;
    private HelperRepository helperRepository;
    private PresentRepository presentRepository;

    public ControllerImpl(){
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper = null;

        if (type.equals("Happy")){
            helper = new Happy(helperName);
        }
        else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
        this.helperRepository.add(helper);
        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        var helper = this.helperRepository.findByName(helperName);
        if (helper == null){
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        InstrumentImpl instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        PresentImpl present = new PresentImpl(presentName, energyRequired);
        this.presentRepository.add(present);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        var helpers = this.helperRepository.getModels()
                .stream().filter(x -> x.getEnergy() > 50)
                .collect(Collectors.toList());

        if (helpers.size() == 0){
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        var present = this.presentRepository.findByName(presentName);
        ShopImpl craft = new ShopImpl();
        int count = 0;
        boolean isDone = false;
        for (var helper : helpers){
            count += craft.craft(present, helper);

            if (present.isDone()){
                isDone = true;
                break;
            }
        }

        countOfCraftedPresents++;
        return String.format(ConstantMessages.PRESENT_DONE, presentName, isDone ? "done" : "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, count);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d presents are done!", countOfCraftedPresents));
        sb.append("Helpers info:");

        for (var helper : helperRepository.getModels()){
            sb.append("Name: " + helper.getName());
            sb.append("Energy: " + helper.getEnergy());
            sb.append(String.format("Instruments: %d not broken left", helper.getInstruments().stream().filter(x -> !x.isBroken()).count()));
        }

        return sb.toString().trim();
    }
}
