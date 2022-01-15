package abyss.world.blocks.heat;

import arc.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.ui.*;
import mindustry.world.Block;

public class HeatBlock extends Block {
	// damage that the block does when destroyed * block size
	public int explodeDamage = 16; 
	// min heat that the block can have
	public float minHeat = 25f;
	// max heat that the block can have
	public float maxHeat = 1000f;

	public HeatBlock(String name) {
		super(name);
		solid = destructible = true;
	}

	@Override
	public void setBars() {
		super.setBars();
		bars.add("heat", entity -> new Bar("bar.heat", Pal.turretHeat, () -> entity.heat/maxHeat));
	}

	public class HeatBlockBuild extends Building {
		float heat = minHeat;
		@Override
		public void onDestroyed() {
			super.onDestroyed();
			if (this.heat < 45f) {
				return;
			}
			Damage.damage(x, y, explodeDamage * this.size);
		}

		public boolean acceptHeat() {
			return true;
		}

		public void addHeat(float amount) {
			this.heat += amount;
		}
		public void setHeat(float amount) {
			this.heat = amount;
		}
		public void distributeHeat(float amount) {
			float dim = 0f;
			for (int i = 0; i < this.proximity.size; i++) {
				if (this.proximity.get(i) instanceof HeatBlockBuild) {
					if (this.proximity.get(i).acceptHeat()) {
						this.proximity.get(i).addHeat(amount);
						dim++;
					}
				}
			}
			addHeat(-amount * dim);
		}

		public void updateHeat() {
			if (this.heat < minHeat) {
				this.heat -= Time.delta();
			}
		}

		@Override
		public void updateTile() {
			updateHeat();
			if (this.heat > maxHeat) {
				Core.app.exit();
			}
			distributeHeat(1);
		}
	}
}