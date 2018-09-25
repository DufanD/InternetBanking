package singleton;

import service.NasabahService;
import service.TabunganService;

public class AppSingleton {
    private static AppSingleton instance = null;
    private TabunganService tabunganService;
    private NasabahService nasabahService;

    public AppSingleton() {
        init();
    }

    public static AppSingleton getInstance() {
        if (instance == null) {
            instance = new AppSingleton();
        }
        return instance;
    }

    private void init() {
        tabunganService = new TabunganService();
        nasabahService  = new NasabahService();
    }

    public TabunganService getTabunganService() {
        return tabunganService;
    }

    public NasabahService getNasabahService() {
        return nasabahService;
    }
}
