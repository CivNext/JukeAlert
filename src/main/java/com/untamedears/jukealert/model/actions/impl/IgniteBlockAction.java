package com.untamedears.jukealert.model.actions.impl;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.untamedears.jukealert.model.actions.LoggedActionPersistence;
import com.untamedears.jukealert.model.actions.abstr.SnitchAction;

import vg.civcraft.mc.civmodcore.inventorygui.DecorationStack;
import vg.civcraft.mc.civmodcore.inventorygui.IClickable;

public class IgniteBlockAction extends SnitchAction  {
	
	public static final String ID = "IGNITE_BLOCK";

	private Location location;
	
	public IgniteBlockAction(long time, UUID player, Location location) {
		super(time, player);
		this.location = location;
	}

	@Override
	public IClickable getGUIRepresentation() {
		ItemStack is = new ItemStack(Material.FLINT_AND_STEEL);
		super.enrichGUIItem(is);
		return new DecorationStack(is);
	}
	
	@Override
	protected Location getLocationForStringRepresentation() {
		return location;
	}
	
	@Override
	public LoggedActionPersistence getPersistence() {
		return new LoggedActionPersistence(getPlayer(), location, time, null);
	}

	@Override
	public String getIdentifier() {
		return ID;
	}
	
	/**
	 * @return Location the fire was put at
	 */
	public Location getLocation() {
		return location;
	}

	@Override
	protected String getChatRepresentationIdentifier() {
		return "Ignited";
	}

}