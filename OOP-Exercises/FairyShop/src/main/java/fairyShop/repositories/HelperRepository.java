package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;

public class HelperRepository implements Repository<Helper>{
    private Collection<Helper> helpers;

    public HelperRepository(){
        this.helpers = new ArrayList<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return this.helpers;
    }

    @Override
    public void add(Helper model) {
        this.helpers.add(model);
    }

    @Override
    public boolean remove(Helper model) {
        return this.helpers.remove(model);
    }

    @Override
    public Helper findByName(String name) {
        return this.helpers.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
