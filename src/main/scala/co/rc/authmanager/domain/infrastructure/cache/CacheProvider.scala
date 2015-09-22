package co.rc.authmanager.domain.infrastructure.cache

import scalacache._
import scalacache.lrumap._

/**
 * Trait that defines application cache provider
 */
trait CacheProvider {

  /**
   * Implicit cache definition using ScalaCache
   */
  implicit def cache: ScalaCache

}

/**
 * Object that implements global cache
 */
object CacheProvider extends CacheProvider {

  /**
   * Implicit cache implementation using ScalaCache and LruMap
   */
  override implicit val cache: ScalaCache = ScalaCache( LruMapCache( 2000 ) )

}
