#include <tap++/tap++.h>
#include <iostream>
#include <string>

int foo() {
  return 2;
}

std::string bar() {
  return "a string";
}

int main() {
  TAP::plan(3);
  TAP::ok(true, "This test passes");
  std::cout << "Testing to see if this line breaks the parser\n";
  TAP::is(foo(), 1, "foo() should be 1");
  TAP::is(bar(), "a string", "bar() should be \"a string\"");
  return TAP::exit_status();
}
