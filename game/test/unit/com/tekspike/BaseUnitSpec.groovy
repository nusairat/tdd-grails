package com.tekspike

import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder
import grails.plugin.spock.*

class BaseUnitSpec extends UnitSpec {
  protected void setup() {
     PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
  }

  protected void tearDown() {
     PluginManagerHolder.pluginManager = null
  }
}