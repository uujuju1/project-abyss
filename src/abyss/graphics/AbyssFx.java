package abyss.graphics;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;

import static mindustry.Vars.*;

public class AbyssFx {

	public static final Effect
		smallVoidExplosion = new Effect(60f, e -> {
			Draw.color(Color.black);
			Lines.stroke(e.fout() * 10f);
			Lines.circle(e.x, e.y, e.fin() * 40f);
			Draw.alpha(e.fout());
			Fill.circle(e.x, e.y, e.fin() * 40f);
			Draw.alpha(1f);

			Angles.randLenVectors(e.id, 10, 40f * e.finpow(), (x, y) -> {
				Fill.circle(e.x + x, e.y + y, e.fout() * 4f + 0.5f);
			});
		}),
		mediumVoidExplosion = new Effect(60f, e -> {
			Draw.color(Color.black);
			Lines.stroke(e.fout() * 10f);
			Lines.circle(e.x, e.y, e.fin() * 80f);
			Draw.alpha(e.fout());
			Fill.circle(e.x, e.y, e.fin() * 80f);
			Draw.alpha(1f);

			Angles.randLenVectors(e.id, 20, 80f * e.finpow(), (x, y) -> {
				Fill.circle(e.x + x, e.y + y, e.fout() * 4f + 0.5f);
			});
		}),
		largeVoidExplosion = new Effect(60f, e -> {
			Draw.color(Color.black);
			Lines.stroke(e.fout() * 10f);
			Lines.circle(e.x, e.y, e.fin() * 120f);
			Draw.alpha(e.fout());
			Fill.circle(e.x, e.y, e.fin() * 120f);
			Draw.alpha(1f);

			Angles.randLenVectors(e.id, 30, 120f * e.finpow(), (x, y) -> {
				Fill.circle(e.x + x, e.y + y, e.fout() * 4f + 0.5f);
			});
		}),
		
		blastHit = new Effect(20f, e -> {
			float w = 16f * e.fout();
			float r = 10f;

			Draw.alpha(e.fout());

			Drawf.tri(e.x, e.y, 8f, w, e.rotation);
			Drawf.tri(e.x, e.y, 8f, w, e.rotation + 45);
			Drawf.tri(e.x, e.y, 8f, w, e.rotation - 45);
			Drawf.tri(e.x, e.y, 8f, -w, e.rotation);

			Lines.stroke(3f * e.fout());
			Lines.circle(e.x, e.y, r * 5f * e.fin());

			Draw.alpha(e.fout()/2f);

			Fill.circle(e.x, e.y, r);

			Draw.alpha(1f);

			Lines.circle(e.x, e.y, r);
		}),
		abyssShootBig = new Effect(30f, e -> {
			Draw.color(Color.white, Color.black, e.fin());
			float w = 1f + 5f * e.fout();
			Drawf.tri(e.x, e.y, w, 30f * e.fout(), e.rotation);
			Drawf.tri(e.x, e.y, w, 6f * e.fout(), e.rotation + 180f);
			
			Angles.randLenVectors(e.id, 10, 5f * e.fin() * 10f, e.rotation, 10f, (x, y) -> {
				Fill.rect(e.x + x, e.y + y, 2f * e.fout(), 2f * e.fout(), 45f);
			});
		}),
		terreniumExplosion = new Effect(60f, e -> {
			Lines.stroke(1f * e.fout());
			Draw.alpha(1f);
			Draw.color(Color.valueOf("D9826C"), Color.valueOf("ffffff"), e.fin());
			Angles.randLenVectors(e.id, 10, 80f * e.finpow(), (x, y) -> {
			  Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 10f * e.fout());
			});
			Lines.stroke(3f * e.fout());
			Draw.alpha(e.fout());
			Lines.circle(e.x, e.y, 120f * e.fin());
		}),

		neutronCharge = new Effect(30f, e -> {
			Lines.stroke(Interp.sine.apply(e.fin() * 2) * 2);
			Lines.poly(e.x, e.y, 4, 50 * e.fout(), 360 * e.fout());
			Lines.poly(e.x, e.y, 4, 50 * e.fout(), 360 * e.fout() + 45);
		}),
		neutronShoot = new Effect(30f, e -> {
			Drawf.tri(e.x, e.y, 8 * e.fout(), 50 * e.fout(), 0 + e.rotation);
			Drawf.tri(e.x, e.y, 8 * e.fout(), 50 * e.fout(), 45 + e.rotation);
			Drawf.tri(e.x, e.y, 8 * e.fout(), 50 * e.fout(), -45 + e.rotation);
		}),

		singularityForged = new Effect(30f, e -> {
			for(int i = 0; i < 5; i++) {
				Drawf.tri(e.x, e.y, 8, 25 * e.fout(), i * (360/5) + 90 * e.fin());
			}
			Angles.randLenVectors(e.id, 10, 40 * e.finpow(), (x, y) -> {
				Fill.circle(e.x + x, e.y + y, Interp.sine.apply(e.fin() * 2));
			});
		}),

		gasFlame = new Effect(30f, e -> {
			Color[] colors = {Color.white, Color.valueOf("D6D6D6"), Color.valueOf("A8A8A8")};
			for(int i = 0; i < 3; i++) {
				Draw.color(colors[i]);
				Angles.randLenVectors(e.id + i, 5, 80 * e.finpow(), e.rotation, i + 1 * 5, (x, y) -> {
					Fill.circle(e.x + x, e.y + y, 3 * e.fout());
				});
			}
		}),
		gasFlameHit = new Effect(30f, e -> {
			Draw.color(Color.white, Color.valueOf("A8A8A8"), e.fin());
			Lines.stroke(e.fout());
			Angles.randLenVectors(e.id, 2, 15 * e.finpow(), e.rotation, 50, (x, y) -> {
				float ang = Mathf.angle(x, y);
				Lines.lineAngle(e.x + x, e.y + y, ang, 3 * e.foutpow());
			});
		}),

		smallHeavyExplosion = new Effect(30f, e -> {
			Draw.color(Pal.darkishGray);
			Draw.alpha(e.fout());
			Lines.stroke(3 * e.fout());

			Fill.circle(e.x, e.y, 32 * e.fin());

			Draw.color(Pal.darkestGray);

			Lines.circle(e.x, e.y, 32 * e.fin());
		}),
		mediumHeavyExplosion = new Effect(60f, e -> {
			Draw.color(Pal.darkishGray);
			Draw.alpha(e.fout());
			Lines.stroke(5 * e.fout());

			Fill.circle(e.x, e.y, 64 * e.fin());

			Draw.color(Pal.darkestGray);

			Lines.circle(e.x, e.y, 64 * e.fin());
		}),
		higeHeavyExplosion = new Effect(90f, e -> {
			Draw.color(Pal.darkishGray);
			Draw.alpha(e.fout());
			Lines.stroke(7 * e.fout());

			Fill.circle(e.x, e.y, 96 * e.fin());

			Draw.color(Pal.darkestGray);

			Lines.circle(e.x, e.y, 96 * e.fin());
		});
}