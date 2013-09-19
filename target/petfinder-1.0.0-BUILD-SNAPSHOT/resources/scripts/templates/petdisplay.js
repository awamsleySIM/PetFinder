(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['petdisplay'] = template(function (Handlebars,depth0,helpers,partials,data) {
  this.compilerInfo = [4,'>= 1.0.0'];
helpers = this.merge(helpers, Handlebars.helpers); data = data || {};
  var buffer = "", stack1, stack2, options, self=this, functionType="function", escapeExpression=this.escapeExpression, helperMissing=helpers.helperMissing;

function program1(depth0,data) {
  
  var buffer = "", stack1, stack2;
  stack2 = helpers['if'].call(depth0, ((stack1 = data),stack1 == null || stack1 === false ? stack1 : stack1.index), {hash:{},inverse:self.noop,fn:self.program(2, program2, data),data:data});
  if(stack2 || stack2 === 0) { buffer += stack2; }
  buffer += escapeExpression((typeof depth0 === functionType ? depth0.apply(depth0) : depth0));
  return buffer;
  }
function program2(depth0,data) {
  
  
  return ", ";
  }

function program4(depth0,data) {
  
  var buffer = "", stack1, options;
  buffer += "\r\n		<li>";
  options = {hash:{},data:data};
  buffer += escapeExpression(((stack1 = helpers.formatPetOption || depth0.formatPetOption),stack1 ? stack1.call(depth0, depth0, options) : helperMissing.call(depth0, "formatPetOption", depth0, options)))
    + "</li>\r\n	";
  return buffer;
  }

  buffer += "<img src=\""
    + escapeExpression(((stack1 = ((stack1 = ((stack1 = ((stack1 = ((stack1 = depth0.media),stack1 == null || stack1 === false ? stack1 : stack1.photos)),stack1 == null || stack1 === false ? stack1 : stack1.photo)),stack1 == null || stack1 === false ? stack1 : stack1[0])),stack1 == null || stack1 === false ? stack1 : stack1.value)),typeof stack1 === functionType ? stack1.apply(depth0) : stack1))
    + "\" /><br/>\r\nName: ";
  if (stack2 = helpers.name) { stack2 = stack2.call(depth0, {hash:{},data:data}); }
  else { stack2 = depth0.name; stack2 = typeof stack2 === functionType ? stack2.apply(depth0) : stack2; }
  buffer += escapeExpression(stack2)
    + "<br/>\r\nGender: ";
  options = {hash:{},data:data};
  buffer += escapeExpression(((stack1 = helpers.formatSex || depth0.formatSex),stack1 ? stack1.call(depth0, depth0.sex, options) : helperMissing.call(depth0, "formatSex", depth0.sex, options)))
    + "<br/>\r\nAge: ";
  options = {hash:{},data:data};
  buffer += escapeExpression(((stack1 = helpers.formatAge || depth0.formatAge),stack1 ? stack1.call(depth0, depth0.age, options) : helperMissing.call(depth0, "formatAge", depth0.age, options)))
    + "<br/>\r\nSize: ";
  options = {hash:{},data:data};
  buffer += escapeExpression(((stack1 = helpers.formatSize || depth0.formatSize),stack1 ? stack1.call(depth0, depth0.size, options) : helperMissing.call(depth0, "formatSize", depth0.size, options)))
    + "<br/>\r\nBreed: ";
  stack2 = helpers.each.call(depth0, ((stack1 = depth0.breeds),stack1 == null || stack1 === false ? stack1 : stack1.breed), {hash:{},inverse:self.noop,fn:self.program(1, program1, data),data:data});
  if(stack2 || stack2 === 0) { buffer += stack2; }
  buffer += "\r\n<ul>\r\n	";
  stack2 = helpers.each.call(depth0, ((stack1 = depth0.options),stack1 == null || stack1 === false ? stack1 : stack1.option), {hash:{},inverse:self.noop,fn:self.program(4, program4, data),data:data});
  if(stack2 || stack2 === 0) { buffer += stack2; }
  buffer += "\r\n</ul>\r\n<br/><br/>\r\n\r\n";
  if (stack2 = helpers.description) { stack2 = stack2.call(depth0, {hash:{},data:data}); }
  else { stack2 = depth0.description; stack2 = typeof stack2 === functionType ? stack2.apply(depth0) : stack2; }
  if(stack2 || stack2 === 0) { buffer += stack2; }
  return buffer;
  });
})();