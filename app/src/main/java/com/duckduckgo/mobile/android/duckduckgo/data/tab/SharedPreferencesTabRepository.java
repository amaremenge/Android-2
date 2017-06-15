package com.duckduckgo.mobile.android.duckduckgo.data.tab;

import android.support.annotation.NonNull;

import com.duckduckgo.mobile.android.duckduckgo.domain.tab.Tab;
import com.duckduckgo.mobile.android.duckduckgo.domain.tab.TabRepository;

import java.util.List;

/**
 * Created by fgei on 6/14/17.
 */

public class SharedPreferencesTabRepository implements TabRepository {

    private TabSharedPreferences tabSharedPreferences;
    private TabJsonEntityMapper tabJsonEntityMapper;

    public SharedPreferencesTabRepository(@NonNull TabSharedPreferences tabSharedPreferences, @NonNull TabJsonEntityMapper tabJsonEntityMapper) {
        this.tabSharedPreferences = tabSharedPreferences;
        this.tabJsonEntityMapper = tabJsonEntityMapper;
    }

    @Override
    public List<? extends Tab> getAll() {
        return tabSharedPreferences.getAll();
    }

    @Override
    public void insert(Tab tab) {
        tabSharedPreferences.insert(tabJsonEntityMapper.map(tab));
    }

    @Override
    public void deleteAll() {
        tabSharedPreferences.deleteAll();
    }
}
