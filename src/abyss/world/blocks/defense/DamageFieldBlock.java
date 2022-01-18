package abyss.world.blocks.defense;

import arc.*;
import arc.math.*;
import arc.util.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.graphics.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.entities.*;
import mindustry.world.Block;

public class DamageFieldBlock extends Block { 
	public float range = 80f;
	public int damage = 10;
	public @Nullable StatusEffect statusEffect;
	public Color statusColor;
	public float statusEffectDuration = 60f;

	public float reloadTime = 60f;
	public boolean targetsAir = true, targetsGround = true;

	public TextureRegion top;

	public DamageFieldBlock(String name) {
		super(name);
		solid = destructible = sync = update = hasItems = hasLiquids = true;
	}

	@Override
	public void drawPlace(int x, int y, int rotation, boolean valid) {
		super.drawPlace(x, y, rotation, valid);
		Drawf.dashCircle(x * 8, y * 8, range, Pal.placing);
	}

	@Override
	public void load() {
		super.load();
		top = Core.atlas.find(name + "-top");
	}

	public class DamageFieldBlockBuild extends Building {
		float reload = 0f;
		float alpha = 0f;
		@Override
		public void drawSelect() {
			Drawf.dashCircle(x, y, range, team.color);
		}

		@Override
		public void updateTile() {
			super.updateTile();
			if (cons.valid()) {
				alpha = Mathf.approachDelta(alpha, 1f, 0.007f);
				if (reload >= reloadTime) {
					consume();
					Damage.damage(this.team, x, y, range, damage, targetsAir, targetsGround);
					if (statusEffect != null) {
						Damage.status(this.team, x, y, range, statusEffect, statusEffectDuration, targetsAir, targetsGround);
					}
					reload = 0f;
				}
				reload += Time.delta;
			} else {
				alpha = Mathf.approachDelta(alpha, 0f, 0.007f);
			}
		}

		public void draw() {
			super.draw();
			Draw.color(statusColor);
			Draw.rect(top, x, y, 0f);
			Draw.z(Layer.groundUnit + 0.001f);
			Draw.alpha(0.5f * alpha);
			Fill.circle(x, y, range + Mathf.absin(2f, 1f));
			Draw.alpha(1f * alpha);
			Draw.color(statusColor.mul(0.5f));
			Lines.stroke(3f * alpha);
			Lines.circle(x, y, range + Mathf.absin(2f, 1f));
			Draw.color();
		}
	}
}