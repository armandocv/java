set table 'dat_results/res_input.dat'
set dgrid3d 7,22
splot 'inputs/input.txt' u 1:2:($3 * 100)
unset table
plot 'dat_results/res_input.dat' with image
