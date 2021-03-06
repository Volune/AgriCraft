/*
 * 
 */
package com.infinityraider.agricraft.reference;

//NBT tags

/**
 * Class for tracking AgriCraftNBT names.
 * 
 * <s>This is fine, as these are never supposed to change, across all classes.</s>
 * Edit: This class leads to too much confusion, and classes loading the wrong things, without permission.
 * 
 * @since 2.0.0
 */
@Deprecated
public interface AgriNBT {

	String CROSS_CROP = "agri_cross_crop";
	String VINE = "agri_vine";
	String DISCOVERED_SEEDS = "agri_discovered";
	String LEVEL = "agri_level";
	String ID = "agri_id";
	String META = "agri_meta";
	String MATERIAL = "agri_material";
	String MATERIAL_META = "agri_material_meta";
	String IS_SPRINKLED = "agri_sprinkled";
	String POWER = "agri_power";
	String INVENTORY = "agri_inventory";
	String COUNT = "agri_count";
	String SEED = "agri_seed";
	String X = "agri_X";
	String Y = "agri_Y";
	String Z = "agri_Z";
	String FLAG = "agri_flag";
	String DIRECTION = "agri_direction";
	String MULTI_BLOCK = "agri_multiblock";
	
}
