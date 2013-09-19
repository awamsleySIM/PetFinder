(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['petlist'] = template(function (Handlebars,depth0,helpers,partials,data) {
  this.compilerInfo = [4,'>= 1.0.0'];
helpers = this.merge(helpers, Handlebars.helpers); data = data || {};
  var stack1, functionType="function", escapeExpression=this.escapeExpression, helperMissing=helpers.helperMissing, self=this;

function program1(depth0,data) {
  
  var buffer = "", stack1, stack2, options;
  buffer += "\r\n	<div class=\"mini-pet-record\">\r\n		<img src=\""
    + escapeExpression(((stack1 = ((stack1 = ((stack1 = ((stack1 = ((stack1 = depth0.media),stack1 == null || stack1 === false ? stack1 : stack1.photos)),stack1 == null || stack1 === false ? stack1 : stack1.photo)),stack1 == null || stack1 === false ? stack1 : stack1[1])),stack1 == null || stack1 === false ? stack1 : stack1.value)),typeof stack1 === functionType ? stack1.apply(depth0) : stack1))
    + "\" /><br/>\r\n		";
  if (stack2 = helpers.name) { stack2 = stack2.call(depth0, {hash:{},data:data}); }
  else { stack2 = depth0.name; stack2 = typeof stack2 === functionType ? stack2.apply(depth0) : stack2; }
  buffer += escapeExpression(stack2)
    + "<br/>\r\n		";
  options = {hash:{},data:data};
  buffer += escapeExpression(((stack1 = helpers.formatSize || depth0.formatSize),stack1 ? stack1.call(depth0, depth0.size, options) : helperMissing.call(depth0, "formatSize", depth0.size, options)))
    + " ";
  options = {hash:{},data:data};
  buffer += escapeExpression(((stack1 = helpers.formatAge || depth0.formatAge),stack1 ? stack1.call(depth0, depth0.age, options) : helperMissing.call(depth0, "formatAge", depth0.age, options)))
    + " ";
  options = {hash:{},data:data};
  buffer += escapeExpression(((stack1 = helpers.formatSex || depth0.formatSex),stack1 ? stack1.call(depth0, depth0.sex, options) : helperMissing.call(depth0, "formatSex", depth0.sex, options)))
    + "\r\n	</div>\r\n";
  return buffer;
  }

  stack1 = helpers.each.call(depth0, depth0.pet, {hash:{},inverse:self.noop,fn:self.program(1, program1, data),data:data});
  if(stack1 || stack1 === 0) { return stack1; }
  else { return ''; }
  });
})();