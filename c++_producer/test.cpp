#include <tap++/tap++.h>
#include <string>

int foo() {
  return 2;
}

std::string bar() {
  return "a string";
}

int main() {
  tap::plan(3);
  tap::ok(true, "This test passes");
  tap::is(foo(), 1, "foo() should be 1");
  tap::is(bar(), "a string", "bar() should be \"a string\"");
  return exit_status();
}
