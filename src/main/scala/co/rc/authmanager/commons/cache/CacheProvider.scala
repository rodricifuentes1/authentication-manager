package co.rc.authmanager.commons.cache

import scalacache._
import scalacache.lrumap._

/**
 * Trait that defines application cache provider
 */
trait CacheProvider {

  implicit def cache: ScalaCache

}

/**
 * Object that implements global cache
 */
object CacheProvider extends CacheProvider {

  override implicit val cache: ScalaCache = ScalaCache( LruMapCache( 2000 ) )

}
