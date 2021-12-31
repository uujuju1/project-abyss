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
		});
		
}