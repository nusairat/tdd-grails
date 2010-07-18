package com.tekspike

class DisplayTagLib {
  static namespace = 'dt'
  
  def format = { attrs ->
    out << "Hello ${attrs.name}"
  }
  
}