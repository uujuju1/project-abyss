package abyss.type.draw;

import arc.graphics.*;
import arc.graphics.g2d.*;

public class DrawEnergy extends WeaponDrawer {
	public Color[] colors = {Pal.heal, Color.white};
	public float minRadius = 10f, mag = 1f;
	float radius = 1f;

	@Override
	public void draw(Unit unit, WeaponMount mount) {
		radius = mount.reload * reload;
		Draw.color(colors[1]);
		Fill.circle(mount.x, mount.y, (minRadius + (Mathf.sinDeg(Time.time) * mag)) * radius * unit.elevation);

		Draw.color(colors[2]);
		Fill.circle(mount.x, mount.y, (minRadius/2 + (Mathf.sinDeg(Time.time) * mag)) * radius * unit.elevation);
	} 

	@Override
	public void drawOutline(Unit unit, WeaponMount mount) {} 
}