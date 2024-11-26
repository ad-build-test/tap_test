#include <tap++/tap++.h>
#include <string>

using namespace TAP;

int foo() {
  return 2;
}

std::string bar() {
  return "a string";
}

int main() {
  plan(3);
  ok(true, "This test passes");
  is(foo(), 1, "foo() should be 1");
  is(bar(), "a string", "bar() should be \"a string\"");
  return exit_status();
}