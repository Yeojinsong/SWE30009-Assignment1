def original_program(A, B):
    A = A - B
    C = A * 2
    return C

def incorrect_programs(A, B):
    incorrect_results = []
    # For incorrect "-" operator
    incorrect_results.append((A + B) * 2)
    incorrect_results.append((A * B) * 2)
    incorrect_results.append((A / B) * 2)
    # For incorrect "*" operator
    incorrect_results.append(A - B + 2)
    incorrect_results.append(A - B - 2)
    incorrect_results.append((A - B) / 2)
    # For both incorrect
    incorrect_results.extend([(A + B) + 2, (A * B) + 2, (A / B) + 2])
    incorrect_results.extend([(A + B) - 2, (A * B) - 2, (A / B) - 2])
    incorrect_results.extend([(A + B) / 2, (A * B) / 2, (A / B) / 2])
    
    return incorrect_results

B = 1
ambiguous_A_values = []
for A in range(-100, 101):  # arbitrary range from -100 to 100, can be expanded
    orig_result = original_program(A, B)
    for incorrect_result in incorrect_programs(A, B):
        if orig_result == incorrect_result:
            ambiguous_A_values.append(A)
            break  # No need to check other incorrect programs for this A value

print("Ambiguous A values for B=1 are:", ambiguous_A_values)
