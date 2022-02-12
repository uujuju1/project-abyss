package abyss.type.weapons;

import arc.*;
import arc.math.*;
import arc.util.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.graphics.*;
import mindustry.entities.*;
import mindustry.entities.units.*;
// weapon with custom cell drawing based on unit's health
public class CellWeapon extends Weapon {
	public TextureRegion cellRegion;

	public CellWeapon(String name) {
		super(name);
	}

	@Override
	public void load() {
		super.load();
		cellRegion = Core.atlas.find(name + "-cell");
	}

	public Color cellColor(Unit unit){
		float f = Mathf.clamp(unit.healthf());
		return Tmp.c1.set(Color.black).lerp(unit.team.color, f + Mathf.absin(Time.time, Math.max(f * 5f, 1f), 1f - f));
	}

	public void drawCell(Unit unit, WeaponMount mount){
		float
			rotation = unit.rotation - 90,
			weaponRotation = rotation + (rotate ? mount.rotation : 0),
			recoil = -((mount.reload) / reload * this.recoil),
			wx = unit.x + Angles.trnsx(rotation, x, y) + Angles.trnsx(weaponRotation, 0, recoil),
			wy = unit.y + Angles.trnsy(rotation, x, y) + Angles.trnsy(weaponRotation, 0, recoil);
		applyColor(unit);

		Draw.color(cellColor(unit));
		Draw.rect(cellRegion, wx, wy, weaponRotation);
		Draw.reset();
	}

	@Override
	public void draw(Unit unit, WeaponMount mount) {
		super.draw(unit, mount);
		drawCell(unit, mount);
	}

	public void applyColor(Unit unit){
		Draw.color();
		Tmp.c1.set(Color.white).lerp(Pal.heal, Mathf.clamp(unit.healTime - unit.hitTime));
		Draw.mixcol(Tmp.c1, Math.max(unit.hitTime, Mathf.clamp(unit.healTime)));

		if(unit.drownTime > 0 && unit.floorOn().isDeep()){
			Draw.mixcol(unit.floorOn().mapColor, unit.drownTime * 0.8f);
		}
	}
}