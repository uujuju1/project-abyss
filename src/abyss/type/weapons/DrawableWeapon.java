package abyss.type.weapon.*;

import mindustry.gen.*;
import mindustry.type.*;
import mindustry.entities.*;
import mindustry.entities.units.*;
import abyss.type.draw.*;

public class DrawableWeapon extends Weapon {
	public WeaponDrawer drawer = new WeaponDrawer();

	public DrawableWeapon(String name) {
		super(name);
	}

	@Override
	public void load() {
		drawer.load();
	}

	@Override
	public void draw(Unit unit, WeaponMount mount) {
		drawer.draw(unit, mount);
	}

	@Override
	public void drawOutline(Unit unit, WeaponMount mount) {
		drawer.drawOutline(unit, mount);
	}
}