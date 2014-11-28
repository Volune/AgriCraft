package com.InfinityRaider.AgriCraft.items.crafting;

import com.InfinityRaider.AgriCraft.reference.Names;
import com.InfinityRaider.AgriCraft.utility.OreDictHelper;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipeCustomWood implements IRecipe{
    public ItemStack result;
    public boolean[][] recipe;

    public RecipeCustomWood(ItemStack result, boolean[][] recipe) {
        this.result = result;
        this.recipe = recipe;
    }

    @Override
    public boolean matches(InventoryCrafting invCrafting, World world) {
        ItemStack material=null;
        for(int row=0;row<recipe.length;row++) {
            for(int column=0;column<recipe[row].length;column++) {
                ItemStack stackInSlot = invCrafting.getStackInSlot(row*3+column);
                if (stackInSlot==null) {
                    if(recipe[row][column]) {
                        return false;       //stack in slot is null, but recipe slot isn't
                    }
                }
                else {
                    if(recipe[row][column]) {
                        if(OreDictHelper.hasOreId(stackInSlot, Names.plankWood)) {
                            if(material==null) {
                                material = stackInSlot.copy();
                            }
                            else {
                                if (!(material.getItem() == stackInSlot.getItem() && material.getItemDamage() == stackInSlot.getItemDamage())) {
                                    return false;   //stack in slot does not match material
                                }
                            }
                        }
                        else {
                            return false;   //stack in slot is not wood
                        }
                    }
                    else {
                        return false;   //stack in slot is not null, but recipe slot is
                    }
                }
            }
        }
        /*
        ItemStack wood = invCrafting.getStackInSlot(0);
        if(wood==null || !OreDictHelper.hasOreId(wood, "plankWood")) {
            return false;           //stack is not wood
        }
        for(int i=1;i<invCrafting.getSizeInventory();i++) {
            ItemStack stackAtIndex = invCrafting.getStackInSlot(i);
            if (i == 1 || i == 4) {
                if (stackAtIndex!=null) {
                    return false;   //stack in slot 1 or 4
                }
            }
            else if (stackAtIndex==null || stackAtIndex.getItem()==null) {
                return false;       //no stack in slot
            }
            else if(wood.getItem()!=stackAtIndex.getItem() || wood.getItemDamage()!=stackAtIndex.getItemDamage()) {
                return false;       //stack is not the same as the rest
            }
        }
        */
        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting invCrafting) {
        ItemStack result = null;
        for(int i=0;i<invCrafting.getSizeInventory();i++) {
            if (invCrafting.getStackInSlot(i) != null && invCrafting.getStackInSlot(i).getItem() != null) {
                if (OreDictHelper.hasOreId(invCrafting.getStackInSlot(i), "plankWood")) {
                    result = this.result.copy();
                    NBTTagCompound tag = new NBTTagCompound();
                    tag.setString(Names.material, Block.blockRegistry.getNameForObject(((ItemBlock) invCrafting.getStackInSlot(i).getItem()).field_150939_a));
                    tag.setInteger(Names.materialMeta, invCrafting.getStackInSlot(i).getItemDamage());
                    result.stackTagCompound = tag;
                    return result;
                }
            }
        }
        return result;
    }

    @Override
    public int getRecipeSize() {
        return 9;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
}

