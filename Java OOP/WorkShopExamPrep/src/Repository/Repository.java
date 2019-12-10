package Repository;

import hardwareComponents.Hardware;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Map<String, Hardware> dumbRepository;

    public Repository(HashMap<String, Hardware>dumbRepository) {
       this.dumbRepository = dumbRepository;
    }

    public void fillDumbRepository(String name, Hardware hardware){
        dumbRepository.putIfAbsent(name, hardware);
    }

    public Map<String, Hardware> getDumbRepository() {
        return dumbRepository;
    }
}
