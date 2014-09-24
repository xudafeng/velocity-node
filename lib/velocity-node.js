/* ================================================================
 * velocity-node by xdf(xudafeng[at]126.com)
 *
 * first created at : Wed Sep 24 2014 18:18:16 GMT+0800 (CST)
 *
 * ================================================================
 * Copyright 2014 xdf
 *
 * Licensed under the MIT License
 * You may not use this file except in compliance with the License.
 *
 * ================================================================ */

'use strict';

require('colorx');
var exec = require('child_process').exec;
var util = require('xutil');
var platform = process.platform;
var logx = require('logx');
var path = require('path');
var binDir = path.join(__dirname, '..', 'bin', path.sep);

function VelocityNode (options) {
  this.data = options.data || {};
  this.template = path.resolve(options.template);
  this.init();
}

VelocityNode.prototype.init = function() {
  exec('java -jar '+ binDir +'velocity-node.jar '+ JSON.stringify(this.data) +' '+ this.template, function(error, stdout) {
    if (error) throw error;
    console.log(stdout)
  });
}

module.exports = VelocityNode;
