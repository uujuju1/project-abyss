package abyss.type.draw;

import arc.Core;
import arc.util.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.Time;
import mindustry.gen.Unit;

public class DrawRotor {
	public final String name;
	public TextureRegion rotorRegion, jointRegion;

	public float x = 0f, y = 0f, s = 0f;

	float rotation = 0f;

	public DrawRotor(String name) {
		this.name = name;
	}

	public void load() {
		rotorRegion = Core.atlas.find(name);
		jointRegion = Core.atlas.find(name + "-joint");
	}

	public void update() {
		rotation += Time.delta * s;
		if (rotation > 360f) {
			rotation -= 360f;
		}
	}

	public void draw(Unit unit) {
		float rx = unit.x + Angles.trnsx(Unit.rotation - 90, x, y);
		float ry = unit.y + Angles.trnsy(Unit.rotation - 90, x, y);

		Draw.rect(rotorRegion, rx, ry, rotation + unit.rotation);
		Draw.rect(jointRegion, rx, ry, 0 + unit.rotation);
		
	}
}