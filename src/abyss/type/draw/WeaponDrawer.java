package abyss.type.draw;

import arc.*;
import arc.math.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.gen.*;
// drawer class for drawableWeapon
public class WeaponDrawer {
	public TextureRegion region, heatRegion, outlineRegion;

	// some copy pasted code to use normal weapon drawing as default
	public void load(){
		region = Core.atlas.find(name, Core.atlas.find("clear"));
		heatRegion = Core.atlas.find(name + "-heat");
		outlineRegion = Core.atlas.find(name + "-outline");
	}

	public void draw(Unit unit, WeaponMount mount){
		float
		rotation = unit.rotation - 90,
		weaponRotation  = rotation + (rotate ? mount.rotation : 0),
		recoil = -((mount.reload) / reload * this.recoil),
		wx = unit.x + Angles.trnsx(rotation, x, y) + Angles.trnsx(weaponRotation, 0, recoil),
		wy = unit.y + Angles.trnsy(rotation, x, y) + Angles.trnsy(weaponRotation, 0, recoil);

		if(shadow > 0){
			Drawf.shadow(wx, wy, shadow);
		}

		if(outlineRegion.found() && top){
			Draw.rect(outlineRegion,
			wx, wy,
			outlineRegion.width * Draw.scl * -Mathf.sign(flipSprite),
			region.height * Draw.scl,
			weaponRotation);
		}

		Draw.rect(region,
		wx, wy,
		region.width * Draw.scl * -Mathf.sign(flipSprite),
		region.height * Draw.scl,
		weaponRotation);

		if(heatRegion.found() && mount.heat > 0){
			Draw.color(heatColor, mount.heat);
			Draw.blend(Blending.additive);
			Draw.rect(heatRegion,
			wx, wy,
			heatRegion.width * Draw.scl * -Mathf.sign(flipSprite),
			heatRegion.height * Draw.scl,
			weaponRotation);
			Draw.blend();
			Draw.color();
		}
	}

	public void drawOutline(Unit unit, WeaponMount mount){
		float
		rotation = unit.rotation - 90,
		weaponRotation  = rotation + (rotate ? mount.rotation : 0),
		recoil = -((mount.reload) / reload * this.recoil),
		wx = unit.x + Angles.trnsx(rotation, x, y) + Angles.trnsx(weaponRotation, 0, recoil),
		wy = unit.y + Angles.trnsy(rotation, x, y) + Angles.trnsy(weaponRotation, 0, recoil);

		if(outlineRegion.found()){
			Draw.rect(outlineRegion,
			wx, wy,
			outlineRegion.width * Draw.scl * -Mathf.sign(flipSprite),
			region.height * Draw.scl,
			weaponRotation);
		}
	}
}