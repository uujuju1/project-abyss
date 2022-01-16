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
		});
}