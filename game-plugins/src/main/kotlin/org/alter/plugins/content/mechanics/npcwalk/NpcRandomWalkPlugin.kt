package org.alter.plugins.content.mechanics.npcwalk

import org.alter.api.*
import org.alter.api.cfg.*
import org.alter.api.dsl.*
import org.alter.api.ext.*
import org.alter.game.*
import org.alter.game.model.*
import org.alter.game.model.attr.*
import org.alter.game.model.container.*
import org.alter.game.model.container.key.*
import org.alter.game.model.entity.*
import org.alter.game.model.item.*
import org.alter.game.model.queue.*
import org.alter.game.model.shop.*
import org.alter.game.model.timer.*
import org.alter.game.plugin.*

class NpcRandomWalkPlugin(
    r: PluginRepository,
    world: World,
    server: Server
) : KotlinPlugin(r, world, server) {
        
    init {
        val SEARCH_FOR_ROUTE_TIMER = TimerKey()
        val SEARCH_FOR_ROUTE_DELAY = 15..30

        onGlobalNpcSpawn {
            if (npc.walkRadius > 0) {
                npc.timers[SEARCH_FOR_ROUTE_TIMER] = world.random(SEARCH_FOR_ROUTE_DELAY)
            }
        }
    }
    

//
//on_timer(SEARCH_FOR_ROUTE_TIMER) {
//    if (npc.isActive() && npc.lock.canMove()) {
//        val facing = npc.attr[FACING_PAWN_ATTR]?.get()
//
//        /*
//         * The npc is not facing a player, so it can walk.
//         */
//        if (facing == null) {
//            val rx = world.random(-npc.walkRadius..npc.walkRadius)
//            val rz = world.random(-npc.walkRadius..npc.walkRadius)
//
//            val start = npc.spawnTile
//            val dest = start.transform(rx, rz)
//
//            /*
//             * Only walk to destination if the chunk has previously been created.
//             */
//            if (world.collision.chunks.get(dest, createIfNeeded = false) != null) {
//                npc.walkTo(dest)
//            }
//        }
//    }
//
//    npc.timers[SEARCH_FOR_ROUTE_TIMER] = world.random(SEARCH_FOR_ROUTE_DELAY)
//}

}
