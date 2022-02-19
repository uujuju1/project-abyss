package abyss.world.blocks.defense;

import arc.*;
import arc.graphics.g2d.*;
import mindustry.world.blocks.defense.turrets.*;
// turret with custom rotating base
public class BaseItemTurret extends ItemTurret {
	public TextureRegion icon, wing;

	public BaseItemTurret(String name) {
		super(name);
	}

	@Override
	public void load() {
		icon = Core.atlas.find(name + "-icon");
		wing = Core.atlas.find(name + "-wing");
	}

	@Override
	public TextureRegion[] icons() {
		return new TextureRegion[]{icon};
	}

	public class BaseItemTurretBuild extends ItemTurret.ItemTurretBuild {
		@Override
		public void draw() {
			Draw.rect(wing, x, y, rotation - 90);
			super.draw();
		}
	}
}