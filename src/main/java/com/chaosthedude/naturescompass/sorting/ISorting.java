package com.chaosthedude.naturescompass.sorting;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.biome.Biome;

import java.util.Comparator;

@Environment(EnvType.CLIENT)
public interface ISorting<T> extends Comparator<Biome> {

    @Override
    public int compare(Biome biome1, Biome biome2);

    public T getValue(Biome biome);

    public ISorting<?> next();

    public String getLocalizedName();

}